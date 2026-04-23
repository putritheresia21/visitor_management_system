@extends('layouts.app')

@section('title', 'Dashboard')

@section('content')

    <div style="display:grid; grid-template-columns:repeat(3,1fr); gap:16px; margin-bottom:24px;">

        <div style="background:white; border-radius:12px; padding:20px; text-align:center; box-shadow:0 2px 8px rgba(0,0,0,0.08); border-left:4px solid #6200EE;">
            <div style="font-size:36px; font-weight:bold; color:#6200EE;">{{ $totalVisitors }}</div>
            <div style="font-size:14px; color:#666; margin-top:4px;">Total Pengunjung</div>
        </div>

        <div style="background:white; border-radius:12px; padding:20px; text-align:center; box-shadow:0 2px 8px rgba(0,0,0,0.08); border-left:4px solid #03DAC5;">
            <div style="font-size:36px; font-weight:bold; color:#03DAC5;">{{ $totalVisits }}</div>
            <div style="font-size:14px; color:#666; margin-top:4px;">Total Kunjungan</div>
        </div>

        <div style="background:white; border-radius:12px; padding:20px; text-align:center; box-shadow:0 2px 8px rgba(0,0,0,0.08); border-left:4px solid #FF6D00;">
            <div style="font-size:36px; font-weight:bold; color:#FF6D00;">{{ $totalCompanies }}</div>
            <div style="font-size:14px; color:#666; margin-top:4px;">Perusahaan Asal</div>
        </div>

    </div>


    <div style="display:grid; grid-template-columns:repeat(2,1fr); gap:16px; margin-bottom:24px;">

        <div style="background:white; border-radius:12px; padding:20px; box-shadow:0 2px 8px rgba(0,0,0,0.08);">
            <div style="font-size:15px; font-weight:bold; color:#333; margin-bottom:16px; padding-bottom:8px; border-bottom:2px solid #6200EE;">
                 Karyawan Paling Banyak Dikunjungi
            </div>
            <div id="chart_employees" style="height:300px;"></div>
        </div>

        <div style="background:white; border-radius:12px; padding:20px; box-shadow:0 2px 8px rgba(0,0,0,0.08);">
            <div style="font-size:15px; font-weight:bold; color:#333; margin-bottom:16px; padding-bottom:8px; border-bottom:2px solid #03DAC5;">
                Departemen Paling Banyak Dikunjungi
            </div>
            <div id="chart_departements" style="height:300px;"></div>
        </div>

    </div>

    <div style="background:white; border-radius:12px; padding:20px; box-shadow:0 2px 8px rgba(0,0,0,0.08);">
        <div style="font-size:15px; font-weight:bold; color:#333; margin-bottom:16px; padding-bottom:8px; border-bottom:2px solid #FF6D00;">
            Perusahaan Asal Pengunjung
        </div>
        <div id="chart_companies" style="height:350px;"></div>
    </div>

@endsection

@push('scripts')
<script>
    google.charts.load('current', { packages: ['corechart'] });
    google.charts.setOnLoadCallback(drawCharts);


    // google.charts.load('current', { packages: ['corechart'] });
    // google.charts.setOnLoadCallback(drawCharts);

    function drawCharts() {
        drawEmployeeChart();
        drawDepartementChart();
        drawCompanyChart();
    }

    function drawEmployeeChart() {
        var data = google.visualization.arrayToDataTable([
            ['Karyawan', 'Jumlah Kunjungan', { role: 'style' }],
            @foreach($topEmployees as $employee)
            ['{{ $employee->employee->name }}', {{ $employee->visits }}, '#6200EE'],
            @endforeach
        ]);

        var options = {
            legend: { position: 'none' },
            chartArea: { width: '70%', height: '75%' },
            hAxis: { title: 'Jumlah Kunjungan', minValue: 0 },
            animation: { startup: true, duration: 800, easing: 'out' }
        };

        new google.visualization.BarChart(
            document.getElementById('chart_employees')
        ).draw(data, options);
    }

    function drawDepartementChart() {
        
        var data = google.visualization.arrayToDataTable([
            ['Departemen', 'Jumlah Kunjungan'],
            @foreach($topDepartements as $dept)
            ['{{ $dept->departement->departement_name ?? "-" }}', {{ $dept->visits }}],
            @endforeach
        ]);

        var options = {
            legend: { position: 'none' },
            chartArea: { width: '70%', height: '75%' },
            hAxis: { title: 'Jumlah Kunjungan', minValue: 0 },
            animation: { startup: true, duration: 800, easing: 'out' }
        };

        new google.visualization.BarChart(
            document.getElementById('chart_departements')
        ).draw(data, options);
    }

    function drawCompanyChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('number', 'Index');
        data.addColumn('number', 'Jumlah Tamu');
        data.addColumn({ type: 'string', role: 'tooltip', p: { html: true } });
        data.addColumn({ type: 'string', role: 'style' });

        var colors = ['#6200EE','#03DAC5','#FF6D00','#E91E63','#2196F3','#4CAF50','#FF5722','#9C27B0'];

        var rows = [];
        @foreach($companies as $index => $company)
        rows.push([
            {{ $index + 1 }},
            {{ $company->total }},
            '<div style="padding:8px"><b>{{ $company->company }}</b><br>Jumlah: {{ $company->total }} tamu</div>',
            'point { size: 12; fill-color: ' + colors[{{ $index }} % colors.length] + '; }'
        ]);
        @endforeach

        data.addRows(rows);

        new google.visualization.ScatterChart(
            document.getElementById('chart_companies')
        ).draw(data, {
            tooltip: { isHtml: true },
            legend: { position: 'none' },
            chartArea: { width: '80%', height: '75%' },
            hAxis: { title: 'Perusahaan (Index)' },
            vAxis: { title: 'Jumlah Tamu', minValue: 0 },
            animation: { startup: true, duration: 800, easing: 'out' }
        });
    }

    //window.addEventListener('resize', drawCharts);
</script>
@endpush
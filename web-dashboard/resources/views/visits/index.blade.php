@extends('layouts.app')

@section('title', 'History Kunjungan')

@section('content')

    <div style="background:white; border-radius:12px; padding:20px; box-shadow:0 2px 8px rgba(0,0,0,0.08);">

        <div style="display:flex; justify-content:space-between; align-items:center; margin-bottom:20px;">
            <div style="font-size:16px; font-weight:bold; color:#333;">
                History Kunjungan
            </div>
            <a href="{{ route('visits.export') }}"
               style="background:#03DAC5; color:white; padding:8px 16px; border-radius:8px; text-decoration:none; font-size:14px;">
                Export Excel
            </a>
        </div>

        <div style="overflow-x:auto;">
            <table style="width:100%; border-collapse:collapse; font-size:14px;">
                <thead>
                    <tr style="background:#f8f8f8;">
                        <th style="padding:12px; text-align:left; border-bottom:2px solid #eee; color:#666;">#</th>
                        <th style="padding:12px; text-align:left; border-bottom:2px solid #eee; color:#666;">Nama Visitor</th>
                        <th style="padding:12px; text-align:left; border-bottom:2px solid #eee; color:#666;">Perusahaan</th>
                        <th style="padding:12px; text-align:left; border-bottom:2px solid #eee; color:#666;">Tujuan</th>
                        <th style="padding:12px; text-align:left; border-bottom:2px solid #eee; color:#666;">Karyawan Dituju</th>
                        <th style="padding:12px; text-align:left; border-bottom:2px solid #eee; color:#666;">Departemen</th>
                        <th style="padding:12px; text-align:left; border-bottom:2px solid #eee; color:#666;">Tanggal</th>
                    </tr>
                </thead>
                <tbody>
                    @foreach($visits as $visit)
                    <tr style="border-bottom:1px solid #f0f0f0;">
                        <td style="padding:12px; color:#999;">{{ $visit->id }}</td>
                        <td style="padding:12px; font-weight:500;">{{ $visit->visitor->name ?? '-' }}</td>
                        <td style="padding:12px; color:#666;">{{ $visit->visitor->company ?? '-' }}</td>
                        <td style="padding:12px;">
                            <span style="background:#EDE7F6; color:#6200EE; padding:4px 10px; border-radius:20px; font-size:12px;">
                                {{ $visit->purpose }}
                            </span>
                        </td>
                        <td style="padding:12px;">{{ $visit->employee->name ?? '-' }}</td>
                        <td style="padding:12px; color:#666;">{{ $visit->departement->departement_name ?? '-' }}</td>
                        <td style="padding:12px; color:#666;">{{ $visit->created_at->format('d M Y H:i') }}</td>
                    </tr>
                    @endforeach
                </tbody>
            </table>
        </div>

        <div style="margin-top:16px; display:flex; align-items:center; justify-content:center;">
            {{ $visits->links('pagination.icon-fixed') }}
        </div>

    </div>

@endsection
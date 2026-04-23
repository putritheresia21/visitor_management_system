@if ($paginator->hasPages())
<div>
    <div class="text-sm text-gray-600">
        Showing {{ $paginator->firstItem() }} 
        to {{ $paginator->lastItem() }} 
        of {{ $paginator->total() }} results
    </div>

    <div class = "flex items-center gap-2">
        @if ($paginator->onFirstPage())
            <span class="px-2 py-1 text-gray-400">
                <
            </span>
        @else
            <a href="{{ $paginator->previousPageUrl() }}" 
               class="px-2 py-1 border rounded hover:bg-gray-100">
                <
            </a>
        @endif

        @foreach ($elements as $element)
            @if (is_array($element))
                @foreach ($element as $page => $url)
                    @if ($page == $paginator->currentPage())
                        <span class="px-3 py-1 bg-purple-600 text-white rounded">
                            {{ $page }}
                        </span>
                    @else
                        <a href="{{ $url }}" 
                           class="px-3 py-1 border rounded hover:bg-gray-100">
                            {{ $page }}
                        </a>
                    @endif
                @endforeach
            @endif
        @endforeach

         @if ($paginator->hasMorePages())
            <a href="{{ $paginator->nextPageUrl() }}" 
               class="px-2 py-1 border rounded hover:bg-gray-100">
                >
            </a>
        @else
            <span class="px-2 py-1 text-gray-400">
                >
            </span>
        @endif
    </div>
</div>
@endif
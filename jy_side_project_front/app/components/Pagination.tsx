import Link from "next/link";
import { createPaginationUrl } from "../lib/pagination";

interface PaginationProps {
  currentPage: number;
  totalPages: number;
  basePath: string;
  pageSize?: number;
  additionalParams?: Record<string, string>;
}

export default function Pagination({
  currentPage,
  totalPages,
  basePath,
  pageSize,
  additionalParams,
}: PaginationProps) {
  if (totalPages <= 1) {
    return null;
  }

  const pages = [];
  const maxVisible = 5;

  // 페이지 번호 계산
  let startPage = Math.max(1, currentPage - Math.floor(maxVisible / 2));
  let endPage = Math.min(totalPages, startPage + maxVisible - 1);

  if (endPage - startPage < maxVisible - 1) {
    startPage = Math.max(1, endPage - maxVisible + 1);
  }

  for (let i = startPage; i <= endPage; i++) {
    pages.push(i);
  }

  return (
    <div className="flex items-center justify-center gap-2 mt-8">
      {/* 이전 버튼 */}
      {currentPage > 1 ? (
        <Link
          href={createPaginationUrl(
            basePath,
            currentPage - 1,
            pageSize,
            additionalParams
          )}
          className="px-4 py-2 border border-gray-300 rounded-md hover:bg-gray-50 transition-colors"
        >
          이전
        </Link>
      ) : (
        <span className="px-4 py-2 border border-gray-300 rounded-md text-gray-400 cursor-not-allowed">
          이전
        </span>
      )}

      {/* 첫 페이지 */}
      {startPage > 1 && (
        <>
          <Link
            href={createPaginationUrl(basePath, 1, pageSize, additionalParams)}
            className="px-4 py-2 border border-gray-300 rounded-md hover:bg-gray-50 transition-colors"
          >
            1
          </Link>
          {startPage > 2 && <span className="px-2">...</span>}
        </>
      )}

      {/* 페이지 번호 */}
      {pages.map((page) => (
        <Link
          key={page}
          href={createPaginationUrl(basePath, page, pageSize, additionalParams)}
          className={`px-4 py-2 border rounded-md transition-colors ${
            page === currentPage
              ? "bg-blue-600 text-white border-blue-600"
              : "border-gray-300 hover:bg-gray-50"
          }`}
        >
          {page}
        </Link>
      ))}

      {/* 마지막 페이지 */}
      {endPage < totalPages && (
        <>
          {endPage < totalPages - 1 && <span className="px-2">...</span>}
          <Link
            href={createPaginationUrl(
              basePath,
              totalPages,
              pageSize,
              additionalParams
            )}
            className="px-4 py-2 border border-gray-300 rounded-md hover:bg-gray-50 transition-colors"
          >
            {totalPages}
          </Link>
        </>
      )}

      {/* 다음 버튼 */}
      {currentPage < totalPages ? (
        <Link
          href={createPaginationUrl(
            basePath,
            currentPage + 1,
            pageSize,
            additionalParams
          )}
          className="px-4 py-2 border border-gray-300 rounded-md hover:bg-gray-50 transition-colors"
        >
          다음
        </Link>
      ) : (
        <span className="px-4 py-2 border border-gray-300 rounded-md text-gray-400 cursor-not-allowed">
          다음
        </span>
      )}
    </div>
  );
}


/**
 * 서버 페이징 유틸리티 함수
 */

export interface PaginationParams {
  page: number;
  pageSize: number;
}

export interface PaginationResult<T> {
  data: T[];
  total: number;
  page: number;
  pageSize: number;
  totalPages: number;
  hasNext: boolean;
  hasPrev: boolean;
}

/**
 * URL searchParams에서 페이지네이션 파라미터 추출
 */
export function getPaginationParams(
  searchParams: { [key: string]: string | string[] | undefined } = {}
): PaginationParams {
  const page = Number(searchParams.page) || 1;
  const pageSize = Number(searchParams.pageSize) || 10;

  return {
    page: Math.max(1, page),
    pageSize: Math.max(1, Math.min(100, pageSize)), // 최대 100개로 제한
  };
}

/**
 * 페이지네이션 결과 생성
 */
export function createPaginationResult<T>(
  data: T[],
  total: number,
  params: PaginationParams
): PaginationResult<T> {
  const totalPages = Math.ceil(total / params.pageSize);

  return {
    data,
    total,
    page: params.page,
    pageSize: params.pageSize,
    totalPages,
    hasNext: params.page < totalPages,
    hasPrev: params.page > 1,
  };
}

/**
 * 페이지네이션 URL 생성
 */
export function createPaginationUrl(
  basePath: string,
  page: number,
  pageSize?: number,
  additionalParams?: Record<string, string>
): string {
  const params = new URLSearchParams();
  params.set("page", page.toString());
  if (pageSize) {
    params.set("pageSize", pageSize.toString());
  }
  if (additionalParams) {
    Object.entries(additionalParams).forEach(([key, value]) => {
      params.set(key, value);
    });
  }
  return `${basePath}?${params.toString()}`;
}


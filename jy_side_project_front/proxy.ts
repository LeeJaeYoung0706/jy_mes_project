import type { NextRequest } from "next/server";
import { NextResponse } from "next/server";

const R = {
  lovely: {
    base: /^\/lovely(\/|$)/,
    api: /^\/api\/lovely(\/|$)/,
    auth: "auth_lovely",
    role: "role_lovely",
    target: process.env.SPRING_LOVELY_URL ?? "http://localhost:8081",
  },
  portfolio: {
    base: /^\/portfolio(\/|$)/,
    api: /^\/api\/portfolio(\/|$)/,
    auth: "auth_portfolio",
    role: "role_portfolio",
    target: process.env.SPRING_PORTFOLIO_URL ?? "http://localhost:8082",
  },
  mes: {
    base: /^\/mes(\/|$)/,
    api: /^\/api\/mes(\/|$)/,
    auth: "auth_mes",
    role: "role_mes",
    target: process.env.SPRING_MES_URL ?? "http://localhost:8083",
  },
} as const;

function matchAppByPath(pathname: string) {
  return (Object.keys(R) as Array<keyof typeof R>).find(k => R[k].base.test(pathname)) ?? null;
}
function matchAppByApi(pathname: string) {
  return (Object.keys(R) as Array<keyof typeof R>).find(k => R[k].api.test(pathname)) ?? null;
}

export function proxy(req: NextRequest) {
  const { pathname, search } = req.nextUrl;

  // 정적 자산 통과
  if (
      pathname.startsWith("/_next") ||
      pathname.startsWith("/favicon") ||
      pathname.match(/\.(png|jpg|jpeg|gif|svg|ico|webp|avif|css|js|map|txt|json)$/)
  ) return NextResponse.next();

  // 1) API 역프록시: /api/<app>/* → 각 Spring
  const apiApp = matchAppByApi(pathname);
  if (apiApp) {
    const target = new URL(pathname.replace(`/api/${apiApp}`, "") + search, R[apiApp].target);
    return NextResponse.rewrite(target);
  }

  // 2) 페이지 접근 가드(앱별 쿠키)
  const app = matchAppByPath(pathname);
  if (!app) return NextResponse.next(); // 메인/기타 경로는 프리패스

  // const token = req.cookies.get(R[app].auth)?.value;
  // if (!token && pathname !== `/${app}/login`) {
  //   const to = new URL(`/${app}/login`, req.url);
  //   to.searchParams.set("from", pathname);
  //   return NextResponse.redirect(to);
  // }
  return NextResponse.next();
}

// 필요한 경로만 매칭
export const config = {
  matcher: [
    "/lovely/:path*",
    "/portfolio/:path*",
    "/mes/:path*",
    "/api/lovely/:path*",
    "/api/portfolio/:path*",
    "/api/mes/:path*",
  ],
};
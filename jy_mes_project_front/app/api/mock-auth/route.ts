import { NextResponse } from "next/server";

const AUTH_COOKIE = "auth_token";

export async function POST() {
  const response = NextResponse.json({ success: true });
  response.cookies.set(AUTH_COOKIE, "demo-token", {
    httpOnly: true,
    path: "/",
    maxAge: 60 * 60,
  });
  return response;
}

export async function DELETE() {
  const response = NextResponse.json({ success: true });
  response.cookies.set(AUTH_COOKIE, "", {
    httpOnly: true,
    path: "/",
    maxAge: 0,
  });
  return response;
}

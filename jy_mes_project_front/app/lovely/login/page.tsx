'use client';

import { useRouter } from "next/navigation";
import { useState } from "react";

export default function LoginPage() {
  const router = useRouter();
  const [status, setStatus] = useState<string | null>(null);
  const [loading, setLoading] = useState(false);

  const handleLogin = async () => {
    setLoading(true);
    try {
      const res = await fetch("/api/mock-auth", { method: "POST" });
      if (!res.ok) throw new Error("로그인 실패");
      setStatus("로그인 완료! 보호된 페이지로 이동 가능합니다.");
      router.refresh();
    } catch (error) {
      setStatus((error as Error).message);
    } finally {
      setLoading(false);
    }
  };

  const handleLogout = async () => {
    setLoading(true);
    try {
      const res = await fetch("/api/mock-auth", { method: "DELETE" });
      if (!res.ok) throw new Error("로그아웃 실패");
      setStatus("로그아웃 완료! 다시 로그인하세요.");
      router.refresh();
    } catch (error) {
      setStatus((error as Error).message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <section className="mx-auto flex min-h-[calc(100vh-10rem)] w-full max-w-3xl flex-col items-center justify-center gap-6 px-4 text-center">
      <h1 className="text-3xl font-bold text-gray-900 sm:text-4xl">로그인 데모</h1>
      <p className="text-gray-600">
        아래 버튼으로 쿠키 기반 Mock 로그인/로그아웃을 수행하고 보호 페이지 접근 권한을 확인해 보세요.
      </p>
      <div className="flex flex-col gap-4 sm:flex-row">
        <button
          onClick={handleLogin}
          //disabled={loading}
          className="rounded-lg  px-6 py-3 text-white transition-colors hover:bg-blue-700"
          style={{ backgroundColor: loading ? "gray" : "blue" }}
        >
          로그인 쿠키 설정
        </button>
        <button
          onClick={handleLogout}
          //disabled={loading}
          style={{ backgroundColor: loading ? "gray" : "blue" }}
          className="rounded-lg  px-6 py-3 text-white transition-colors hover:bg-gray-800"
        >
          쿠키 제거 (로그아웃)
        </button>
      </div>
      {status && <p className="text-sm text-gray-500">{status}</p>}
    </section>
  );
}

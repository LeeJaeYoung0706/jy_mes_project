import Link from "next/link";

export default function RoutesPage() {
  return (
    <section className="mx-auto flex min-h-[calc(100vh-10rem)] w-full max-w-4xl flex-col items-center justify-center gap-10 px-2 text-center sm:px-4 md:gap-12 lg:max-w-5xl lg:px-8">
      <div className="space-y-4 sm:space-y-6 md:space-y-8">
        <h1 className="text-3xl font-bold text-gray-900 sm:text-4xl md:text-5xl lg:text-6xl">
          Routes 페이지
        </h1>
        <p className="text-base text-gray-600 sm:text-lg md:text-xl">
          라우트 관리 페이지입니다.
        </p>
      </div>
      <div className="flex w-full max-w-xl flex-col gap-4 sm:flex-row sm:justify-center">
        <Link
          href="/"
          className="w-full rounded-lg bg-gray-700 px-6 py-3 text-base font-semibold text-white transition-colors hover:bg-gray-800 sm:w-auto sm:px-8 sm:text-lg"
        >
          메인으로 돌아가기
        </Link>
      </div>
    </section>
  );
}


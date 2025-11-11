export default function MiddlewareGuardPage() {
  return (
    <section className="mx-auto flex min-h-[calc(100vh-10rem)] w-full max-w-4xl flex-col justify-center gap-6 px-4">
      <h1 className="text-3xl font-bold text-gray-900 sm:text-4xl">
        미들웨어 가드 페이지
      </h1>
      <p className="text-gray-600">
        이 페이지는 middleware.ts에서 인증 쿠키를 확인한 후 접근이 허용됩니다. 쿠키가 없으면 로그인 페이지로 리다이렉트됩니다.
      </p>
      <p className="text-gray-500">
        현재는 페이지 자체에 추가 로직이 필요 없고, 보호는 미들웨어에서 처리됩니다.
      </p>
    </section>
  );
}

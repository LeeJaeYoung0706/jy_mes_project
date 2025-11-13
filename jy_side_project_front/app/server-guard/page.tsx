import { cookies } from "next/headers";
import { redirect } from "next/navigation";

export default function ServerGuardPage() {
  const cookieStore = cookies();
  //const token = cookieStore.get("auth_token");

  //if (!token) {
 //   redirect("/login?from=server-guard");
  //}

  return (
    <section className="mx-auto flex min-h-[calc(100vh-10rem)] w-full max-w-4xl flex-col justify-center gap-6 px-4">
      <h1 className="text-3xl font-bold text-gray-900 sm:text-4xl">
        서버 가드 페이지
      </h1>
      <p className="text-gray-600">
        이 페이지는 서버 컴포넌트에서 쿠키를 확인하고, 인증되지 않은 경우 서버에서 바로 로그인 페이지로 리다이렉트합니다.
      </p>
      <p className="text-gray-500">
        {/*현재 쿠키 값: <span className="font-mono text-blue-600">{token?.value}</span>*/}
      </p>
    </section>
  );
}

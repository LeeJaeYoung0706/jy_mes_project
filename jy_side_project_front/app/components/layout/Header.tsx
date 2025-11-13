import Brand from "./Brand";
import NavItem from "./NavItem";

export default function Header() {
  return (
    <header className="border-b border-transparent bg-[var(--brand-600)] text-[var(--brand-200)]">
      <nav className="mx-auto max-w-7xl pr-4 sm:pr-6 lg:pr-8 pl-[50px] lg:pl-[50px]">
        <div className="flex flex-col gap-4 py-4 md:h-16 md:flex-row md:items-center md:justify-between md:py-0">
          {/* 브랜드 */}
          <div className="flex items-center pl-[50px]">
            <Brand />
          </div>

          {/* 네비게이션 */}
          <div className="flex flex-col gap-2 sm:flex-row sm:items-center sm:gap-3">
            <NavItem href="/">메인</NavItem>
            <NavItem href="/routes">Routes</NavItem>
          </div>
        </div>
      </nav>
      {/* 얇은 바 */}
      <div className="h-[2px] w-full bg-[var(--brand-200)]/70" />
    </header>
  );
}

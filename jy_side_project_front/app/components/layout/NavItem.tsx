import Link from "next/link";

interface NavItemProps {
  href: string;
  children: React.ReactNode;
}

export default function NavItem({ href, children }: NavItemProps) {
  return (
    <Link
      href={href}
      className="group w-full rounded-md px-4 py-2 text-center !text-[var(--brand-200)] transition-all hover:bg-white/10 active:scale-[0.99] sm:w-auto"
    >
      <span className="relative">
        {children}
        <span className="absolute -bottom-1 left-0 h-[2px] w-0 bg-[var(--brand-200)] transition-all duration-300 group-hover:w-full" />
      </span>
    </Link>
  );
}

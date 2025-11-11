import Link from "next/link";

export default function Brand() {
  return (
    <Link
      href="/"
      className="text-2xl font-extrabold !text-[var(--brand-200)] transition-colors sm:text-3xl"
    >
      JY MES Project
    </Link>
  );
}

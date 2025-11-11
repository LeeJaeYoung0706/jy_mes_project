interface MainContainerProps {
  children: React.ReactNode;
}

export default function MainContainer({ children }: MainContainerProps) {
  return (
    <main className="flex-1 w-full px-4 py-8 sm:px-6 lg:px-8">{children}</main>
  );
}

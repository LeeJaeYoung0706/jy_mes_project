interface MainContainerProps {
  children: React.ReactNode;
}

export default function MainContainer({ children }: MainContainerProps) {
  return (
    <main style={{backgroundColor: "var(--brand-300)", minWidth: "100vw" , minHeight: "100vh" ,    display: "grid",
      placeItems: "center"
      }}>
      {children}
    </main>
  );
}

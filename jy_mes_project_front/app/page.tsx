import Link from "next/link";
import React from "react";

export default function Home() {

  const containerCss: React.CSSProperties = {
      display: "flex",
      flexWrap: "wrap",
      backgroundColor: "var(--brand-300)",
      width: "100%",
      justifyContent: "center",
      alignItems: "center",
  };

  const articleCss: React.CSSProperties = {
    flexGrow: "1",
    flexBasis: "200px",
    backgroundColor: "var(--brand-300)",
    border: "1px solid black",
    height: "clamp(100px, 50vh, 500px)",
    minWidth: "clamp(280px, calc(100%/3), calc(100%/3))"
  };

  return (
      <section style={containerCss}>
        <article style={articleCss}></article>
        <article style={articleCss}></article>
        <article style={articleCss}></article>
        <article style={articleCss}></article>
      </section>
  );
}





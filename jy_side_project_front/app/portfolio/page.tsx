'use client'
import React from "react";
import CardArticle from "@/app/components/card/CardArticle";

export default function PortfolioPage() {


    return (
        <section className="flex flex-wrap w-full justify-center items-center bg-[var(--brand-300)]">

            <CardArticle variant={1}>
                <div className="flex justify-center items-center flex-wrap py-10">
                    <div
                        className="group relative w-[320px] h-[400px] flex justify-center items-center my-10 mx-8 transition-all duration-500"
                    >

                        <div
                            className="pointer-events-none absolute inset-0 before:content-[''] before:absolute before:top-0 before:left-[50px] before:w-1/2 before:h-full before:rounded-lg before:bg-[linear-gradient(400deg,var(--brand-500),var(--brand-600))] before:skew-x-[15deg] before:transition-all before:duration-500 after:content-[''] after:absolute after:top-0 after:left-[50px] after:w-1/2 after:h-full after:rounded-lg after:bg-[linear-gradient(400deg,var(--brand-500),var(--brand-600))] after:skew-x-[15deg] after:transition-all after:duration-500 after:blur-[30px]
group-hover:before:skew-x-0 group-hover:after:skew-x-0 group-hover:before:left-5 group-hover:after:left-5 group-hover:before:w-[calc(100%-90px)] group-hover:after:w-[calc(100%-90px)]"
                        />


                        <span
                            className="pointer-events-none absolute inset-0 z-[5] before:content-[''] before:absolute before:top-0 before:left-0 before:w-0 before:h-0 before:rounded-lg before:bg-[rgba(255,255,255,0.1)] before:backdrop-blur before:opacity-0 before:transition-all before:duration-150 before:shadow-[0_5px_15px_rgba(0,0,0,0.08)] after:content-[''] after:absolute after:bottom-0 after:right-0 after:w-full after:h-full after:rounded-lg after:bg-[rgba(255,255,255,0.1)] after:backdrop-blur after:opacity-0 after:transition-all after:duration-500 after:shadow-[0_5px_15px_rgba(0,0,0,0.08)] group-hover:before:top-[-50px] group-hover:before:left-[50px] group-hover:before:w-[100px] group-hover:before:h-[100px] group-hover:before:opacity-100 group-hover:after:bottom-[-50px] group-hover:after:right-[50px] group-hover:after:w-[100px] group-hover:after:h-[100px] group-hover:after:opacity-100"
                        />


                        <div
                            className="relative left-0 z-[1] text-white transition-all duration-500 bg-[rgba(255,255,255,0.05)] backdrop-blur rounded-lg shadow-[0_5px_15px_rgba(0,0,0,0.1)] px-10 py-5 group-hover:-left-6 group-hover:px-10 group-hover:py-12">
                            <h2 className="text-2xl font-semibold mb-2">Lovely</h2>
                            <p className="text-[1.1em] leading-tight mb-2">추억공간</p>
                            <a
                                href="#"
                                className="inline-block text-[1.1em] font-bold mt-1 text-[#111] bg-white px-4 py-2 rounded hover:bg-[#ffcf4d] hover:border hover:border-[rgba(255,0,88,0.4)] hover:shadow-[0_1px_15px_rgba(1,1,1,0.2)]"
                            >
                                Read More
                            </a>
                        </div>
                    </div>
                </div>
            </CardArticle>
            <CardArticle variant={2}>
                <div className="flex justify-center items-center flex-wrap py-10">
                    <div
                        className="group relative w-[320px] h-[400px] flex justify-center items-center my-10 mx-8 transition-all duration-500"
                    >

                        <div
                            className="pointer-events-none absolute inset-0 before:content-[''] before:absolute before:top-0 before:left-[50px] before:w-1/2 before:h-full before:rounded-lg before:bg-[linear-gradient(250deg,var(--brand-400),var(--brand-500))] before:skew-x-[15deg] before:transition-all before:duration-500 after:content-[''] after:absolute after:top-0 after:left-[50px] after:w-1/2 after:h-full after:rounded-lg after:bg-[linear-gradient(250deg,var(--brand-400),var(--brand-500))] after:skew-x-[15deg] after:transition-all after:duration-500 after:blur-[30px]
group-hover:before:skew-x-0 group-hover:after:skew-x-0 group-hover:before:left-5 group-hover:after:left-5 group-hover:before:w-[calc(100%-90px)] group-hover:after:w-[calc(100%-90px)]"
                        />


                        <span
                            className="pointer-events-none absolute inset-0 z-[5] before:content-[''] before:absolute before:top-0 before:left-0 before:w-0 before:h-0 before:rounded-lg before:bg-[rgba(255,255,255,0.1)] before:backdrop-blur before:opacity-0 before:transition-all before:duration-150 before:shadow-[0_5px_15px_rgba(0,0,0,0.08)] after:content-[''] after:absolute after:bottom-0 after:right-0 after:w-full after:h-full after:rounded-lg after:bg-[rgba(255,255,255,0.1)] after:backdrop-blur after:opacity-0 after:transition-all after:duration-500 after:shadow-[0_5px_15px_rgba(0,0,0,0.08)] group-hover:before:top-[-50px] group-hover:before:left-[50px] group-hover:before:w-[100px] group-hover:before:h-[100px] group-hover:before:opacity-100 group-hover:after:bottom-[-50px] group-hover:after:right-[50px] group-hover:after:w-[100px] group-hover:after:h-[100px] group-hover:after:opacity-100"
                        />


                        <div
                            className="relative left-0 z-[1] text-white transition-all duration-500 bg-[rgba(255,255,255,0.05)] backdrop-blur rounded-lg shadow-[0_5px_15px_rgba(0,0,0,0.1)] px-10 py-5 group-hover:-left-6 group-hover:px-10 group-hover:py-12">
                            <h2 className="text-2xl font-semibold mb-2">Portfolio</h2>
                            <p className="text-[1.1em] leading-tight mb-2">개발자 이재영 포트폴리오</p>
                            <a
                                href="#"
                                className="inline-block text-[1.1em] font-bold mt-1 text-[#111] bg-white px-4 py-2 rounded hover:bg-[#ffcf4d] hover:border hover:border-[rgba(255,0,88,0.4)] hover:shadow-[0_1px_15px_rgba(1,1,1,0.2)]"
                            >
                                Read More
                            </a>
                        </div>
                    </div>
                </div>
            </CardArticle>
            <CardArticle variant={3}>
                <div className="flex justify-center items-center flex-wrap py-10">
                    <div
                        className="group relative w-[320px] h-[400px] flex justify-center items-center my-10 mx-8 transition-all duration-500"
                    >
                        {/* skewed gradient panels (palette 3) */}
                        <div
                            className="pointer-events-none absolute inset-0 before:content-[''] before:absolute before:top-0 before:left-[50px] before:w-1/2 before:h-full before:rounded-lg before:bg-[linear-gradient(100deg,var(--brand-400),var(--brand-600))] before:skew-x-[15deg] before:transition-all before:duration-500 after:content-[''] after:absolute after:top-0 after:left-[50px] after:w-1/2 after:h-full after:rounded-lg after:bg-[linear-gradient(100deg,var(--brand-400),var(--brand-600))] after:skew-x-[15deg] after:transition-all after:duration-500 after:blur-[30px]
group-hover:before:skew-x-0 group-hover:after:skew-x-0 group-hover:before:left-5 group-hover:after:left-5 group-hover:before:w-[calc(100%-90px)] group-hover:after:w-[calc(100%-90px)]"
                        />


                        <span
                            className="pointer-events-none absolute inset-0 z-[5] before:content-[''] before:absolute before:top-0 before:left-0 before:w-0 before:h-0 before:rounded-lg before:bg-[rgba(255,255,255,0.1)] before:backdrop-blur before:opacity-0 before:transition-all before:duration-150 before:shadow-[0_5px_15px_rgba(0,0,0,0.08)] after:content-[''] after:absolute after:bottom-0 after:right-0 after:w-full after:h-full after:rounded-lg after:bg-[rgba(255,255,255,0.1)] after:backdrop-blur after:opacity-0 after:transition-all after:duration-500 after:shadow-[0_5px_15px_rgba(0,0,0,0.08)] group-hover:before:top-[-50px] group-hover:before:left-[50px] group-hover:before:w-[100px] group-hover:before:h-[100px] group-hover:before:opacity-100 group-hover:after:bottom-[-50px] group-hover:after:right-[50px] group-hover:after:w-[100px] group-hover:after:h-[100px] group-hover:after:opacity-100"
                        />


                        <div
                            className="relative left-0 z-[1] text-white transition-all duration-500 bg-[rgba(255,255,255,0.05)] backdrop-blur rounded-lg shadow-[0_5px_15px_rgba(0,0,0,0.1)] px-10 py-5 group-hover:-left-6 group-hover:px-10 group-hover:py-12">
                            <h2 className="text-2xl font-semibold mb-2">MES</h2>
                            <p className="text-[1.1em] leading-tight mb-2">MES 서브 프로젝트</p>
                            <a
                                href="#"
                                className="inline-block text-[1.1em] font-bold mt-1 text-[#111] bg-white px-4 py-2 rounded hover:bg-[#ffcf4d] hover:border hover:border-[rgba(255,0,88,0.4)] hover:shadow-[0_1px_15px_rgba(1,1,1,0.2)]"
                            >
                                Read More
                            </a>
                        </div>
                    </div>
                </div>
            </CardArticle>

        </section>
    );
}





import { useNavigate } from "react-router-dom"

import a1 from "../assets/SignAside/a1.jpg"
import a2 from "../assets/SignAside/a2.png"
import a3 from "../assets/SignAside/a3.png"
import { useState } from "react"


function Sign(){
    const navigate = useNavigate()
    const imagesDiv = [a1, a2, a3] = useState([a1, a2, a3])

    return (
        <main className="flex flex-row gap-10 p-10 h-screen min-w-11/12 m-20 mr-10 ml-10 bg-gray-900 overflow-hidden rounded-xl">
            <article className="w-1/2 h-full rounded-xl overflow-hidden">
                <div className="overflow-hidden w-full h-full relative">
                    <img src={a1} alt="a1" className="absolute inset-0 w-full h-full object-cover"/>
                    <img src={a2} alt="a2" className="absolute inset-0 w-full h-full object-cover"/>
                    <img src={a3} alt="a3" className="absolute inset-0 w-full h-full object-cover"/>
                </div>
            </article>
            <article className="w-1/2 h-full p-10">
                <aside className="mb-14">
                    <h1 className="text-5xl text-sky-500 text-shadow-gray-950 text-shadow-sm mb-3">Criar uma conta</h1>
                    <p className="inline text-gray-200">Já tem uma conta?</p>
                    <button className="inline text-sky-500 ml-2">Entrar</button>
                </aside>
                <aside className="flex flex-col h-full">
                    <div className="w-full flex gap-1 justify-between mb-10">
                        <input type="text" name="firstName" id="firstName" placeholder="Nome" className="text-gray-200 bg-gray-900 hover:bg-gray-700 p-3 transition duration-150 rounded-xs border border-gray-800 focus:outline-none" />
                        <input type="text" name="lastName" id="lastName" placeholder="Sobrenome" className="text-gray-200 bg-gray-900 hover:bg-gray-700 p-3 transition duration-150 rounded-xs border border-gray-800 focus:outline-none" />
                    </div>
                    <input type="email" name="email" id="email" placeholder="Email" className="text-gray-200 bg-gray-900 hover:bg-gray-700 p-3 transition duration-150 rounded-xs mb-5 border border-gray-800 focus:outline-none" />
                    <input type="password" name="password" id="password" placeholder="Senha" className="text-gray-200 bg-gray-900 hover:bg-gray-700 p-3 transition duration-150 rounded-xs border border-gray-800 focus:outline-none" />
                    <button className="bg-sky-500 text-white py-2 px-4 rounded-md cursor-pointer hover:bg-sky-600 transition-all mt-20">Criar conta</button>

                    <div className="mt-5">
                        <input className="inline mr-3 accent-sky-500" type="checkbox" required name="AgreeTerms" id="AgreeTerms" />
                        <label className="inline text-gray-200" htmlFor="AgreeTerms">Concordo com os <a className="text-sky-500" href="#">termos e condições</a></label>
                    </div>
                </aside>
            </article>
        </main>
    )
}

export default Sign;
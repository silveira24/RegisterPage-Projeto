import { useEffect, useState, useRef} from "react";
import "./style.css";
import { FaTrash } from "react-icons/fa";
import api from "../../services/api";

function Home() {
    const [users, setUsers] = useState([])

    const inputName = useRef()
    const inputAge = useRef()
    const inputEmail = useRef()

    async function getUsers() {
        const usersFromApi = await api.get("/client")
        setUsers(usersFromApi.data)
    }

    async function registerUsers() {
        await api.post("/client", {
            name: inputName.current.value,
            age: inputAge.current.value,
            email: inputEmail.current.value
        })
        inputName.current.value = ""
        inputAge.current.value = ""
        inputEmail.current.value = ""
        getUsers();
    }

    async function deleteUser(id) {
        await api.delete(`/client/${id}`)
        getUsers();
    }

    useEffect(() => {
        getUsers();
    }, [])

    return (
        <div className="container">
            <form className="card-register">
                <h2>Cadastro de Usuários</h2>
                <input type="text" name="name" placeholder="Nome" ref={inputName}/>
                <input type="number" name="age" placeholder="Idade" ref={inputAge}/>
                <input type="email" name="email" placeholder="E-mail" ref={inputEmail}/>
                <button type="button" onClick={registerUsers}>Cadastrar</button>
            </form>

            <div className="card-users">
                {users.map((user) => {
                    return (
                        <div key={user.id} className="card-user">
                            
                            <div className="user-data">
                                <p>Nome: <span>{user.name}</span></p>
                                <p>Idade: <span>{user.age}</span></p>
                                <p>Email: <span>{user.email}</span></p>
                            </div>

                            <button className="icon" onClick={() => deleteUser(user.id)}>
                                <FaTrash />
                            </button>
                        </div>
                    )
                })}
            </div>
        </div>
    )
}

export default Home;
import { Outlet } from "react-router-dom";
import { HeaderHome } from "../../components/HeaderHome";

export default function Home(){
    return (
        <>
        <HeaderHome />
        <Outlet />
        </>
    )
}
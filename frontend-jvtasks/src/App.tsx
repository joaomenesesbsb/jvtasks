import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom"
import Home from "./routes/Home"

function App() {

  return (
    <BrowserRouter >
        <Routes>
          <Route path="/" element={<Home />} >
          </Route>
          <Route path="*" element={<Navigate to={"/"} />} />
        </Routes>
      </BrowserRouter>
  )
}

export default App

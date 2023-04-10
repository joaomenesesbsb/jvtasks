import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom"
import Home from "./routes/Home"
import Tasks from "./routes/Tasks"

function App() {

  return (
    <BrowserRouter >
        <Routes>
          <Route path="/" element={<Home />} >
          <Route index element={<Tasks />}/>
            <Route path="tasks" element={<Tasks />}/>
          </Route>
          <Route path="*" element={<Navigate to={"/"} />} />
        </Routes>
      </BrowserRouter>
  )
}

export default App

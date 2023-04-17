import { useEffect, useState } from "react";
import CardTask from "../../../components/CardTask";
import LineTask from "../../../components/LineTask/indesx";
import axios from "axios";
import { BASE_URL } from "../../../utils/system";
import Btn from "../../../components/Buttons/Button test";

export default function Tasks() {
  const [tasks, setTasks] = useState<TaskDTO[]>([]);

  useEffect(() => {
    axios.get(`${BASE_URL}/tasks`).then((response) => {
      setTasks(response.data.content);
    });
  }, []);
  return (
    <main className="container mt-20">
      <div className="btn-task_item">
        <Btn title={"Criar Tarefa"} />
        <Btn title={"Editar Tarefa"} />
      </div>
      <div>
        {tasks.map((task) => (
          <LineTask key={task.id} task={task} />
        ))}
      </div>
    </main>
  );
}

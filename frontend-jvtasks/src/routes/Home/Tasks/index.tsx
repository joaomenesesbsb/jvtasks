import { useEffect, useState } from "react";
import LineTask from "../../../components/LineTask/indesx";
import Btn from "../../../components/Buttons/Button test";
import * as taskService from "../../../services/task-service"

type QueryParams = {
  page: number,
  name: string
}

export default function Tasks() {
  const [tasks, setTasks] = useState<TaskDTO[]>([]);

  const [queryParams, setQueryParams] = useState<QueryParams>({
    page: 0,
    name: ''
});

useEffect(() => {
  taskService.findPageRequest(queryParams.page, queryParams.name)
      .then(response => {
        setTasks(tasks.concat(response.data.content))
      })
}, [queryParams]);

  return (
    <main className="container mt-20">
      <div className="btn-task-item">
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

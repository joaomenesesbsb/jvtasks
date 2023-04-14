import { useEffect, useState } from "react";
import CardTask from "../../../components/CardTask";
import LineTask from "../../../components/LineTask/indesx";
import axios from "axios";
import { BASE_URL } from "../../../utils/system";

export default function Tasks() {

  const [tasks, setTasks] = useState<TaskDTO[]>([]);

  useEffect(() => {
    axios.get(`${BASE_URL}/tasks`).then((response) => {
      setTasks(response.data.content);
    });
  }, []);
  return (
    <main className="container">
      <CardTask />
      <table>
        <tbody>
          {tasks.map(task => <LineTask key={task.id} task={task} /> )}
        </tbody>
      </table>
    </main>
  );
}

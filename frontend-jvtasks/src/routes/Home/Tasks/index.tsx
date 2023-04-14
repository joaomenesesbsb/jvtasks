import { useEffect, useState } from "react";
import CardTask from "../../../components/CardTask";
import LineTask from "../../../components/LineTask/indesx";
import axios from "axios";
import { BASE_URL } from "../../../utils/system";

export default function Tasks() {
  const [tasks, setTasks] = useState<TaskDTO[]>([]);

  useEffect(() => {
    axios.get(`${BASE_URL}/tasks`).then((response) => {
      setTasks(response.data);
      console.log("Deu certo")
      console.log(tasks);
    });
  }, []);
  return (
    <main className="container">
      <CardTask />
      <LineTask />
      <table>
        <thead>
          <tr>
            <th>Complete</th>
            <th>Name</th>
            <th>Description</th>
            <th>Prompt</th>
          </tr>
        </thead>
        <tbody>
          {tasks.map((task) => {
            return (
              <tr>
                <td>{task.complete}</td>
                <td>{task.name}</td>
                <td>{task.description}</td>
                <td>{task.prompt}</td>
              </tr>
            );
          })}
          <tr>
            <td>Yes/No</td>
            <td>Task 1</td>
            <td>A description of the task to be completed</td>
            <td>15/04/2023</td>
          </tr>
        </tbody>
      </table>
    </main>
  );
}

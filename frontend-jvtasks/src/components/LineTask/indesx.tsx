import "./styles.css";
import { useEffect, useState } from "react";
import * as dateUtils from "../../utils/date"

type Props = {
  task : TaskDTO;
}

export default function LineTask({task}: Props) {

  const [datePrompt, setDatePrompt ] = useState<string>();

  useEffect(() => {
    setDatePrompt(dateUtils.converterISOToLoalDate(task.prompt));
  },[]);


  return (
    <main>
      <div className="line-container">
        <div className="line-content line-content-check">✔</div>
        <div className="line-content line-content-name">
          <p>{task.name}</p>
        </div>
        <div className="line-content line-content-description">
          <p>{task.description}</p>
        </div>
        <div className="line-content line-content-date">
          <p>{datePrompt}</p>
        </div>
      </div>
    </main>
  );
}

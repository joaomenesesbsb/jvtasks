import "./styles.css";

type Props = {
  task : TaskDTO;
}

export default function LineTask({task}: Props) {
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
          <p>{task.prompt}</p>
        </div>
      </div>
    </main>
  );
}

import "./styles.css";

export default function CardTask() {
  return (
    <div className="btn-task-container">
      <div className="btn-task_box">
        <div className="btn-task_item">
          <div className="btn-task-item_link">
            <div className="btn-task-item_bg"></div>

            <div className="btn-task-item_title">Crias Tarefa</div>
          </div>
        </div>

        <div className="btn-task_item">
          <div className="btn-task-item_link">
            <div className="btn-task-item_bg"></div>

            <div className="btn-task-item_title">Editar Tarefa</div>
          </div>
        </div>
      </div>
    </div>
  );
}

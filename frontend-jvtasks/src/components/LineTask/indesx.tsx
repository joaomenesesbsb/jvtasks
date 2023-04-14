import "./styles.css";

export default function LineTask() {
  return (
    <main>
      <div className="line-container">
        <div className="line-content line-content-check">✔</div>
        <div className="line-content line-content-name">
          <p>Estudar</p>
        </div>
        <div className="line-content line-content-description">
          <p>Lorem ipsum dolor sit amet.</p>
        </div>
        <div className="line-content line-content-date">
          <p>07/02/2023</p>
        </div>
      </div>
    </main>
  );
}

import "./styles.css";

type Props = {
  title : String;
}

export default function Btn({title}: Props) {
  return (
    <div className="btn-task2-item_link">
            <div className="btn-task2-item_bg"></div>

            <div className="btn-task2-item_title">{title}</div>
          </div>
  );
}

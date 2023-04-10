import "./styles.css";

export default function CardTask() {
  return (
    <div className="ag-format-container">
      <div className="ag-courses_box">
        <div className="ag-courses_item">
          <div className="ag-courses-item_link">
            <div className="ag-courses-item_bg"></div>

            <div className="ag-courses-item_title">
              UX/UI Web-Design&#160;+ Mobile Design
            </div>
          </div>
        </div>

        <div className="ag-courses_item">
          <div className="ag-courses-item_link">
            <div className="ag-courses-item_bg"></div>

            <div className="ag-courses-item_title">Interior Design</div>

            <div className="ag-courses-item_date-box">
              Start:
              <span className="ag-courses-item_date">31.10.2022</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

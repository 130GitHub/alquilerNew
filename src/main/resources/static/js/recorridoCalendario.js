const calendarBody = document.getElementById("calendar-body");
const monthYear = document.getElementById("month-year");
const prevBtn = document.getElementById("prev-btn");
const nextBtn = document.getElementById("next-btn");

let currentDate = new Date();
let selectedDate = null;

function renderCalendar() {
  calendarBody.innerHTML = "";
  const firstDayOfMonth = new Date(currentDate.getFullYear(), currentDate.getMonth(), 1);
  const lastDayOfMonth = new Date(currentDate.getFullYear(), currentDate.getMonth() + 1, 0);
  monthYear.textContent = `${currentDate.toLocaleString('default', { month: 'long' })} ${currentDate.getFullYear()}`;

  let date = new Date(firstDayOfMonth);
  while (date <= lastDayOfMonth) {
    const row = document.createElement("tr");
    for (let i = 0; i < 7; i++) {
      const cell = document.createElement("td");
      if (date >= firstDayOfMonth && date <= lastDayOfMonth) {
        cell.textContent = date.getDate();
        cell.addEventListener("click", handleDateClick);
        if (selectedDate && date.getTime() === selectedDate.getTime()) {
          cell.classList.add("selected");
        }
      }
      row.appendChild(cell);
      date.setDate(date.getDate() + 1);
    }
    calendarBody.appendChild(row);
  }
}

function handleDateClick(event) {
  if (selectedDate) {
    selectedDate.classList.remove("selected");
  }
  const cell = event.target;
  selectedDate = cell;
  cell.classList.add("selected");
}

prevBtn.addEventListener("click", () => {
  currentDate.setMonth(currentDate.getMonth() - 1);
  renderCalendar();
});

nextBtn.addEventListener("click", () => {
  currentDate.setMonth(currentDate.getMonth() + 1);
  renderCalendar();
});

renderCalendar();
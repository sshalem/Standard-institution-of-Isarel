const studentInfo = document.getElementById('studentInfo');
const getStudentData = document.getElementById('getStudentData');
const courseData = document.getElementById('table-data');
const studentData = document.querySelector('.student');
const email = document.querySelector('.email');

let studentIdentity = null;

fetch(location).then((res) => {
    for (let header of res.headers.entries()) {
        if (header[0] === 'studentid') {
            console.log(header[1]);
            studentIdentity = header[1];

            // Http Get Request for getting Student who is logged in
            // and display Student details on page
            fetch(`http://localhost:8080/students/get/${studentIdentity}`)
                .then((res) => res.json())
                .then((data) => presentStudentDetailsUI(data));

            /* Http Get Request for geting all the courses a Student:
             * 1. took in the past.
             * 2. assigned too (but hasn't registered yet)
             * 3. registered or has cancled registration
             */
            fetch(`http://localhost:8080/studentcourse/all/${studentIdentity}`)
                .then((res) => res.json())
                .then((data) => presentStudentCoursesUI(data));
        }
    }
});

email.addEventListener('click', function () {});

function presentStudentDetailsUI(data) {
    console.log(data);
    studentData.innerHTML = `
        <div class="student identification">ת.ז.: <span class="studend-data-info">${data.studentIdentity}</span></div>
        <div class="student firstName">שם פרטי: <span class="studend-data-info">${data.firstName}</span></div>
        <div class="student lastName">שם משפחה: <span class="studend-data-info">${data.lastName}</span></div>
        <div class="student email">אי-מייל: <span class="studend-data-info">${data.email}</span><span><button>עדכן אימייל</button></span></div>
        <div class="student password">סיסמא: <span class="studend-data-info">${data.encryptedPassword}</span><span><button>עדכן סיסמא</button></span></div>
        <div class="student logout">
                    <form action="http://localhost:8080/logout" method="post">
                        <button type="submit">יציאה</button>
                    </form>
                </div> 
    `;
}

function presentStudentCoursesUI(data) {
    let coursesTable = document.getElementById('present-courses-table');
    console.log(coursesTable);
    data.forEach((studentCourse) => {
        console.log(studentCourse);
        coursesTable.innerHTML += `
        <tr>
            <td>${studentCourse.courseNumber}</td>
            <td>${studentCourse.courseName}</td>
            <td>${studentCourse.grade}</td>
            <td>${studentCourse.startDate}</td>
            <td>${studentCourse.endDate}</td>
            <td>${studentCourse.registrationDate}</td>
        </tr>`;
    });
}

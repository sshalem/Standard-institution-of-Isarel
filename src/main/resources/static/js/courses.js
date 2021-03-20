const studentInfo = document.getElementById('studentInfo');
const getStudentData = document.getElementById('getStudentData');
const courseData = document.getElementById('table-data');
const studentData = document.querySelector('.student');

let studentIdentity = null;

fetch(location).then((res) => {
    for (let header of res.headers.entries()) {
        if (header[0] === 'studentid') {
            console.log(header[1]);
            studentIdentity = header[1];

            // Http Get Request for Student who is logged in
            // Show student details on page
            fetch(`http://localhost:8080/students/get/${studentIdentity}`)
                .then((res) => res.json())
                .then((data) => presentStudentDetailsUI(data));

            /* Http Get Request 
             1. for all the courses a Student took
             2. for all the courses that are assigned to a student and he can register to them               
            */
            fetch(`http://localhost:8080/studentcourse/all/${studentIdentity}`)
                .then((res) => res.json())
                .then((data) => presentStudentCoursesUI(data));

            // let courseNumber = 2500;
            // fetch(`http://localhost:8080/course/${courseNumber}`)
            //     .then((res) => res.json())
            //     .then((data) => console.log(data));
        }
    }
});

function presentStudentDetailsUI(data) {
    console.log(data);
    studentData.innerHTML = `
        <div class="student identification">ת.ז.: <span class="studend-data-info">${data.studentIdentity}</span></div>
        <div class="student firstName">שם פרטי: <span class="studend-data-info">${data.firstName}</span></div>
        <div class="student lastName">שם משפחה: <span class="studend-data-info">${data.lastName}</span></div>
        <div class="student email">אי-מייל: <span class="studend-data-info">${data.email}</span></div>
        <div class="student password">סיסמא: <span class="studend-data-info">${data.encryptedPassword}</span></div>
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

// console.log(studentCourse);
// coursesTable += `
// <tr>
//     <td>${courseNumber}</td>
//     <td>${courseName}</td>
//     <td>${grade}</td>
//     <td>${startDate}</td>
//     <td>${endDate}</td>
//     <td>${registrationDate}</td>
// </tr>`;

const studentInfo = document.getElementById('studentInfo');
const getStudentData = document.getElementById('getStudentData');
const courseData = document.getElementById('table-data');
const studentData = document.querySelector('.student');

// targeting on button of email modification
const update = document.querySelector('.update');

let studentIdentity = null;
let currentStudentLogged = null;

fetch(location).then((res) => {
    for (let header of res.headers.entries()) {
        if (header[0] === 'studentid') {
            console.log(header[1]);
            studentIdentity = header[1];

            // Http Get Request for getting Student who is logged in
            // and display Student details on page
            fetch(`http://localhost:8080/students/get/${studentIdentity}`)
                .then((res) => res.json())
                .then((data) => studentDetailsUI(data));

            /* Http Get Request for geting all the courses a Student:
             * 1. took in the past.
             * 2. assigned too (but hasn't registered yet)
             * 3. registered or has cancled registration
             */
            fetch(`http://localhost:8080/studentcourse/all/${studentIdentity}`)
                .then((res) => res.json())
                .then((data) => studentCoursesUI(data));
        }
    }
});

function studentDetailsUI(studentDetails) {
    currentStudentLogged = studentDetails;
    const { firstName, lastName, studentIdentity, password, email } = studentDetails;
    document.querySelector('.identification').innerText = studentIdentity;
    document.querySelector('.firstName').innerText = firstName;
    document.querySelector('.lastName').innerText = lastName;
    document.querySelector('.email').innerText = email;
    document.querySelector('.password').innerText = password;
}

function studentCoursesUI(data) {
    let coursesTable = document.getElementById('present-courses-table');
    data.forEach((studentCourse) => {
        const { courseNumber, courseName, grade, startDate, endDate, registrationDate } = studentCourse;
        coursesTable.innerHTML += `
        <tr>
            <td>${courseNumber}</td>
            <td>${courseName}</td>
            <td>${grade}</td>
            <td>${startDate}</td>
            <td>${endDate}</td>
            <td>${registrationDate}</td>
        </tr>`;
    });
}

update.addEventListener('click', function () {});

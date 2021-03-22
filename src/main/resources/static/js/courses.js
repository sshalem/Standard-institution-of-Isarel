const studentInfo = document.getElementById('studentInfo');
const getStudentData = document.getElementById('getStudentData');
const courseData = document.getElementById('table-data');
const studentData = document.querySelector('.student');
const email = document.querySelector('.email');

const modifyEmail = document.getElementById('modifyEmail');
const btnModifyEmail = document.querySelector('.btn-modify-email');

const modifyUpdateCancel = document.getElementById('modifyUpdateCancel');
const btnModifyUpdate = document.querySelector('.btn-modify-update');
const btnModifyCancel = document.querySelector('.btn-modify-cancel');

const btnModifyPassword = document.querySelector('.btn-modify-password');

let studentIdentity = null;

btnModifyEmail.addEventListener('click', function (event) {
    modifyEmail.classList.add('hide');
    modifyUpdateCancel.classList.remove('hide');
});

btnModifyUpdate.addEventListener('click', function (event) {
    modifyUpdateCancel.classList.add('hide');
    modifyEmail.classList.remove('hide');
});

btnModifyCancel.addEventListener('click', function (event) {
    modifyUpdateCancel.classList.add('hide');
    modifyEmail.classList.remove('hide');
});

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

function presentStudentDetailsUI(data) {
    console.log(data);
    document.querySelector('.identification').lastChild.innerText = data.studentIdentity;
    document.querySelector('.firstName').lastChild.innerText = data.firstName;
    document.querySelector('.lastName').lastChild.innerText = data.lastName;
    document.querySelector('.email').childNodes[1].innerText = data.email;
    document.querySelector('.password').childNodes[1].innerText = data.encryptedPassword;
}

function presentStudentCoursesUI(data) {
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

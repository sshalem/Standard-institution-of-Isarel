const studentInfo = document.getElementById('studentInfo');
const getStudentData = document.getElementById('getStudentData');
const courseData = document.getElementById('table-data');
const studentData = document.querySelector('.student');

// targeting on button of email modification
const modifyEmail = document.getElementById('modifyEmail');
const btnModifyEmail = document.querySelector('.btn-modify-email');
const email = document.querySelector('.email');
const emailInput = document.getElementById('email-input');
const modifyUpdateCancel = document.getElementById('modifyUpdateCancel');
const btnEmailUpdate = document.querySelector('.btn-modify-update');
const btnEmailCancel = document.querySelector('.btn-modify-cancel');

// targeting on button password modification
const modifyPassword = document.getElementById('modifyPassword');
const btnModifyPassword = document.querySelector('.btn-modify-password');
const password = document.querySelector('.password');
const passwordInput = document.getElementById('password-input');
const modifyUpdateCancelPassword = document.getElementById('modifyUpdateCancelPassword');
const btnPasswordUpdate = document.querySelector('.btn-modify-update-password');
const btnPasswordCancel = document.querySelector('.btn-modify-cancel-password');

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
    document.getElementById('email-input').value = email;
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

/* 
------------------------------------------
eventListeners for buttons of :
 1. mail <Modification></Modification>
 -----------------------------------------
 */
btnModifyEmail.addEventListener('click', function (event) {
    email.classList.add('hide');
    modifyEmail.classList.add('hide');
    modifyUpdateCancel.classList.remove('hide');
});

btnEmailUpdate.addEventListener('click', function (event) {
    currentStudentLogged.email = emailInput.value;

    const options = {
        method: 'POST',
        headers: {
            Accept: 'application/json, text/plain, */*',
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(currentStudentLogged),
    };

    console.log(options);

    fetch(`http://localhost:8080/students/update`, options)
        .then((res) => res.json())
        .then((data) => studentDetailsUI(data));

    email.classList.remove('hide');
    modifyEmail.classList.remove('hide');
    modifyUpdateCancel.classList.add('hide');
});

btnEmailCancel.addEventListener('click', function (event) {
    email.classList.remove('hide');
    modifyEmail.classList.remove('hide');
    modifyUpdateCancel.classList.add('hide');
});

/* 
------------------------------------------
eventListeners for buttons of :
 1. mail <Modification></Modification>
 -----------------------------------------
 */

btnModifyPassword.addEventListener('click', function (event) {
    password.classList.add('hide');
    modifyPassword.classList.add('hide');
    modifyUpdateCancelPassword.classList.remove('hide');
});

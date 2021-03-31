const studentData = document.querySelector('.student');
const studentUpdate = document.querySelector('.section_student__update');
const update = document.querySelector('.update');
const updateBtn = document.querySelector('.update-button');
const cancelBtn = document.querySelector('.cancel-button');

// targeting input tags
let fName = document.getElementById('fName');
let lName = document.getElementById('lName');
let eMail = document.getElementById('eMail');
let pwd = document.getElementById('pwd');

let studentIdentity = null;
let currentStudentLogged = null;

fetch(location).then((res) => {
    for (let header of res.headers.entries()) {
        if (header[0] === 'studentid') {
            console.log(header[1]);
            studentIdentity = header[1];
            getPersonalInfofLoggedinStudent(studentIdentity);
            getCoursesOfLoggedinStudent(studentIdentity);
        }
    }
});

update.addEventListener('click', function () {
    studentData.classList.add('hide');
    studentUpdate.classList.remove('hide');
});

cancelBtn.addEventListener('click', function () {
    studentData.classList.remove('hide');
    studentUpdate.classList.add('hide');
});

updateBtn.addEventListener('click', function () {
    studentData.classList.remove('hide');
    studentUpdate.classList.add('hide');
});

function studentDetailsUI(studentDetails) {
    currentStudentLogged = studentDetails;
    const { firstName, lastName, studentIdentity, password, email } = studentDetails;
    document.querySelector('.identification').innerText = studentIdentity;
    document.querySelector('.firstName').innerText = firstName;
    document.querySelector('.lastName').innerText = lastName;
    document.querySelector('.email').innerText = email;
    document.querySelector('.password').innerText = password;

    // update input tags of section_student__update
    fName.value = firstName;
    lName.value = lastName;
    eMail.value = email;
    pwd.value = password;
}

function studentCoursesUI(data) {
    let coursesTable = document.getElementById('show-courses-table');
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

function getPersonalInfofLoggedinStudent(studentIdentity) {
    // Http Get Request for getting Student who is logged in
    // and display Student details on page
    fetch(`http://localhost:8080/students/get/${studentIdentity}`)
        .then((res) => res.json())
        .then((data) => studentDetailsUI(data));
}

function getCoursesOfLoggedinStudent(studentIdentity) {
    /* Http Get Request for geting all the courses a Student:
     * 1. took in the past.
     * 2. assigned too (but hasn't registered yet)
     * 3. registered or has cancled registration
     */
    fetch(`http://localhost:8080/studentcourse/all/${studentIdentity}`)
        .then((res) => res.json())
        .then((data) => studentCoursesUI(data));
}

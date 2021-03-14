const studentInfo = document.getElementById('studentInfo');
const getStudentData = document.getElementById('getStudentData');
const courseData = document.getElementById('table-data');
const get = document.getElementById('get');

let studentIdentity = null;

fetch(location).then((res) => {
    for (let header of res.headers.entries()) {
        if (header[0] === 'studentid') {
            console.log(header[1]);
            studentIdentity = header[1];
        }
    }
});

// window.addEventListener('DOMContentLoaded', (event) => {
//     // students/get/{identity}
//     fetch(`http://localhost:8080/students/get/${studentIdentity}`, {
//         method: 'get',
//     })
//         .then((res) => res.json())
//         .then((data) => console.log(data));
// });

get.addEventListener('click', () => {
    fetch(`http://localhost:8080/students/get/${studentIdentity}`)
        .then((res) => res.json())
        .then((data) => console.log(data));
});

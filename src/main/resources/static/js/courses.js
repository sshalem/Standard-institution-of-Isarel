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
            fetch(`http://localhost:8080/students/get/${studentIdentity}`)
                .then((res) => res.json())
                .then((data) => updateStudentDetails(data));

            fetch(`http://localhost:8080/students/get/courses/${studentIdentity}`)
                .then((res) => res.json())
                .then((data) => console.log(data));

            console.log('------------------');
            console.log('------------------');
			
			let courseNumber = 2500; 
            fetch(`http://localhost:8080/course/${courseNumber}`)
                .then((res) => res.json())
                .then((data) => console.log(data));
        }
    }
});

function updateStudentDetails(data) {
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

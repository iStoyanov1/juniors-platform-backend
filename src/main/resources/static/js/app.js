const url = {
    createUser: '/api/register/user'
}
// //
// // fetch(url.createUser, {
// //     method: 'POST', // or 'PUT'
// //     headers: {
// //         'Content-Type': 'application/json',
// //     }
// // })
// //     .then(response => response.json())
// //     .then(data => {
// //         console.log('Success:', data);
// //     })
// //     .catch((error) => {
// //         console.error('Error:', error);
// //     });
//
// const user = {
//     first_name: 'John',
//     last_name: 'Doe',
//     job_title: 'Blogger'
// };
//
// // request options
// const options = {
//     method: 'POST',
//     body: JSON.stringify(user),
//     headers: {
//         'Content-Type': 'application/json'
//     }
// }
//
// // send POST request
// fetch(url.createUser, options)
//     .then(res => res.json())
//     .then(res => console.log(res));

$('#submit-form').submit(function (e){
    const url = $(this).attr('action');

    fetch(url.createUser,{
        method: 'post'
    }).then(data => {
        console.log(data)
        window.location = '/register/user';
    })
    return false
})
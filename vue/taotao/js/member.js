var vue = new Vue({
	el: "#app",
    data:{
		mobile:'18765662252',
		password: '883838',
		userName: '999'
	},
	methods: {
		register: function() {
		axios.post('http://localhost:8010/register?password='+this.password+'&mobile='+this.mobile+'&userName='+this.userName)
		  .then(function (response) {
		    // handle success
			if(response.data.code=200){
				 window.location.href='login.html';
				 return;
			}
		  
		  })
		  .catch(function (error) {
		    // handle error
			alert(error)
		    console.log(error);
		  })
		 
	}
}
})

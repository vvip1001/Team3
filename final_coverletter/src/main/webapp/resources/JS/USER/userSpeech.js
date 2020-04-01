
function add_div(){
	var original = $("#original").clone();
	console.log(original);
	
	$("#cloneDiv").append(original);
	
}



function remove_div(id){
	var field = document.getElementById(id);
	console.log(field);
	var parent = field.parentNode;
	console.log(parent);
	var bro = parent.previousSibling.previousSibling;
	console.log(bro);
	bro.lastChild.remove();
}

var message = document.querySelector("#message"); //p태그 
var button = document.querySelector("#speech"); // start 버튼
var korea = document.querySelector("#korea"); // div
var english = document.querySelector("#korea"); // div
var isRecognizing = false;

try {
	var recognition = new (window.SpeechRecognition
			|| window.webkitSpeechRecognition
			|| window.mozSpeechRecognition || window.msSpeechRecognition)();
} catch (e) {
	console.error(e);
}

recognition.lang = 'ko-KR'; //한국어 인식.
recognition.interimResults = false;
recognition.maxAlternatives = 5;
//recognition.continuous = true;

function speech_to_text() {

	recognition.start();
	isRecognizing = true;

	recognition.onstart = function() {
		console.log("음성인식이 시작 되었습니다.")
		message.innerText = "음성인식 시작...";
		button.innerText = "Listening...";
		button.disabled = true;
	}

	recognition.onspeechend = function() {
		message.innerText = "버튼을 누르고 아무말이나 하세요.";
		button.disabled = false;
		button.innerText = "Start STT";
	}

	recognition.onresult = function(event) { // 인식된 음성이 있을 경우 실행
		console.log('You said: ', event.results[0][0].transcript);
		// 결과를 출력
		var resText = event.results[0][0].transcript;
		korea.value = resText;

		//text to sppech
		text_to_speech(resText);

	};

	recognition.onend = function() {
		message.innerText = "버튼을 누르고 아무말이나 하세요.";
		button.disabled = false;
		button.innerText = "Start STT";
		isRecognizing = false;

	}
}

function stop() { // 음성 인식 종료
	recognition.stop();
	message.innerText = "버튼을 누르고 아무말이나 하세요.";
	button.disabled = false;
	button.innerText = "Start STT";
	isRecognizing = false;

}

// Text to speech
function text_to_speech(txt) {
	// Web Speech API - speech synthesis
	if ('speechSynthesis' in window) {
		// Synthesis support. Make your web apps talk!
		console.log("음성합성을 지원하는  브라우저입니다.");
	}
	var msg = new SpeechSynthesisUtterance();
	var voices = speechSynthesis.getVoices();
	//msg.voice = voices[9]; // 두번째 부터 완전 외국인 발음이 됨. 사용하지 말것.
	msg.voiceURI = 'Google 한국의';
	msg.voiceURI = 'native';
	msg.volume = 1; // 0 to 1 볼륨
	msg.rate = 1.5; // 0.1 to 10 말하는속도
	// msg.pitch = 1.5; //0 to 2 음의 높이
	msg.text = txt;
	msg.lang = 'ko-KR';

	msg.onend = function(e) {
		if (isRecognizing == false) {
			recognition.start();
		}
		console.log('Finished in ' + event.elapsedTime
				+ ' seconds.');
	};
	window.speechSynthesis.speak(msg);
}

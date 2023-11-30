document.addEventListener('DOMContentLoaded', () =>{
    /**
     * Chronomètre
    */
    const ding = new Audio('./assets/ring.mp3');
    const chronoStart = document.getElementById('chrono-start');
    const chronoStop = document.getElementById('chrono-stop');
    const registerBtn = document.getElementById('register-btn');
    const inputChrono = document.getElementById('chrono');
    const registeredTimeList = document.getElementById('registered-time');

    let chronoInterval, count = 0;
    registerBtn.style.visibility = 'hidden';

    chronoStart.addEventListener('click', () => {
        toggleStartStop()
        let  m = 0 , s = 0 , ms = 0;
        chronoInterval = setInterval(() => {
            count++
            ms = count % 60;
            s = Math.floor(count/60 % 60);
            m = Math.floor(count/3600 % 60);
            if(ms < 10) ms = '0'+ms
            if(s < 10) s = '0'+s
            if(m < 10) m = '0'+m
            inputChrono.value = `${m}:${s}:${ms}`;
        }, 10)
        
    })
    chronoStop.addEventListener('click', () => {
        toggleStartStop()
        clearInterval(chronoInterval);
        count = 0;
    })
    registerBtn.addEventListener('click',  () => {
        const registeredTime = document.createElement('li');
        registeredTime.textContent = inputChrono.value;
        registeredTimeList.appendChild(registeredTime);
    })
    const toggleStartStop = () => {
        chronoStart.disabled = !chronoStart.disabled
        chronoStop.disabled = !chronoStop.disabled
        registerBtn.style.visibility = chronoStop.disabled ? 'hidden' : 'visible';
    }
    /**
     * Minuteur
     */
    const inputTimer = document.getElementById('timer');
    const btnTimer = document.getElementById('timer-start');

    btnTimer.addEventListener('click', () => {
        let h, m, s, timerInterval;
        const t = inputTimer.value.split(':')
        let leftTime = (+t[0]*3600)+(+t[1]*60)+(+t[2]);
        console.log(leftTime)
        timerInterval = setInterval(() => {
            leftTime--;
            h = Math.floor(leftTime/3600);
            m = Math.floor(leftTime/60) % 60
            s = leftTime % 60;
            inputTimer.value = `${h<10?'0'+h:h}:${m<10?'0'+m:m}:${s<10?'0'+s:s}`
            if (leftTime <= 0){
                console.log('ding!')
                ding.play();
                setTimeout(() => ding.pause(), 2000);
                clearInterval(timerInterval);
            } 
        },1000);;
    })
})
document.addEventListener('DOMContentLoaded', () => {
    const chatMessages = document.querySelector('.chat-messages');
    const chatInput = document.getElementById('chat-input');
    const sendButton = document.getElementById('send-button');
  
    // STOMP 클라이언트 생성 및 서버 연결
    const client = Stomp.client('ws://43.201.182.155:8080/ws');
    client.connect({}, () => {
      // 채팅방 구독
      client.subscribe('/sub/chatroom/1', (message) => {
        const chatDTO = JSON.parse(message.body);
        const messageElement = document.createElement('div');
        messageElement.textContent = `[${chatDTO.userId}]: ${chatDTO.message}`;
        chatMessages.appendChild(messageElement);
        chatMessages.scrollTop = chatMessages.scrollHeight;
      });
    });
  
    // 메시지 전송 기능
    sendButton.addEventListener('click', () => {
      const message = chatInput.value.trim();
      if (message) {
        const chatDTO = {
          roomId: 1,
          userId: 123, // 문자열로 변경
          message: message,
          time: new Date().toLocaleString(),
          isFirst: false,
          userProfile: 1
        };
        client.send('/pub/chatroom/1', {}, JSON.stringify(chatDTO));
        chatInput.value = '';
      }
    });
  });
  
import sys
sys.path.append('C:/CodigosRed/python/AUDIOEJERCICIO')

import grpc
import audio_pb2
import audio_pb2_grpc
#import pyaudio

def play_audio(stream, audio_data):
    for audio_chunk in audio_data:
        stream.write(audio_chunk)


def run():
    channel = grpc.insecure_channel('localhost:50051')
    stub = audio_pb2_grpc.AudioServiceStub(channel)

    try:
        response_iterator = stub.StreamAudio(audio_pb2.IdAudio(id=1))
        audio_data = [audio_chunk.data for audio_chunk in response_iterator]
        
        p = pyaudio.PyAudio()
        stream = p.open(format=pyaudio.paInt16,
                        channels=1,
                        rate=44100,
                        output=True)
        
        play_audio(stream, audio_data)
        
    except KeyboardInterrupt:
        pass
    finally:
        channel.close()

if __name__ == '__main__':
    run()

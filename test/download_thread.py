import requests
import os
import time
from PyQt5.QtCore import QThread, pyqtSignal


class DownloadWorker(QThread):
    progressBarValue = pyqtSignal(int)

    def __init__(self):
        super(DownloadWorker, self).__init__()
        # self.file_url = file_url

    def run(self):
        self.download_file()


    def set_url(self, file_url):
        self.file_url = file_url

    def download_file(self):
        # if not os.path.exists(path):
        #     os.mkdir(path)

        print(f'下载链接地址 {self.file_url}')
        start = time.time()
        # 流式下载
        response = requests.get(self.file_url, stream=True)
        size = 0
        chunk_size = 1024
        content_size = int(response.headers['Content-length'])
        print(content_size)

        # try:
        if response.status_code == 200:
            name = self.file_url.split('/')[-1]
            # filepath = path + '\name.extension name'
            print(f'filename {name}')
            print(f'abspath {os.path.abspath(os.getcwd())}')
            filepath = os.path.abspath(os.getcwd()) + "\\" + name
            print(filepath)
            with open(filepath, 'wb') as file:
                print(f'file total size is {content_size}')
                for data in response.iter_content(chunk_size=chunk_size):
                    file.write(data)
                    size += len(data)
                    # print(f'download process {size / content_size}')
                    self.progressBarValue.emit(int((size / content_size) * 100))
        end = time.time()
        print(f'file download cost {end - start}ms')
        # except Exception:
        #     print('failed')


if __name__ == '__main__':
    url = 'http://bj.download.cycore.cn/res/9d4b77de-906c-413a-aef3-a1d7f781a5f6/8b3a5fcf-a8a8-4c6a-af1f-c29dbd27b1ca.mp4'
    path = r'E:\工具\''
    # download_file(url, path)

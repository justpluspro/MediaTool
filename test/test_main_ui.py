import sys
from PyQt5.QtWidgets import QApplication, QWidget, QDesktopWidget
from PyQt5.QtWidgets import QVBoxLayout, QHBoxLayout
from PyQt5.QtWidgets import QPushButton, QProgressBar, QLineEdit, QDialog
from PyQt5.QtCore import QRect
from download_thread import DownloadWorker


class MainWindow(QWidget):
    def __init__(self):
        super().__init__()

        self.setWindowTitle('Demo')
        self.setContentsMargins(0, 0, 0, 0)

        # 设置窗体尺寸
        self.resize(1080, 720)

        qr = self.frameGeometry()
        cp = QDesktopWidget().availableGeometry().center()
        qr.moveCenter(cp)

        # 新建主窗口布局
        main_layout = QVBoxLayout()

        # 新建按钮
        start_btn = QPushButton('开始')
        start_btn.clicked.connect(self.start_btn_click)
        main_layout.addWidget(start_btn)


        # 设置下载地址布局
        download_layout = QHBoxLayout()
        self.download_url = QLineEdit()
        # 下载按钮
        download_btn = QPushButton('下载')
        download_btn.clicked.connect(self.start_download_file)

        download_layout.addWidget(self.download_url)
        download_layout.addWidget(download_btn)

        main_layout.addLayout(download_layout)




        # 新建进度条
        download_processbar = QProgressBar()
        download_processbar.setValue(0)
        self.download_worker = DownloadWorker()
        self.download_worker.progressBarValue.connect(self.update_processbar_value)
        self.download_processbar = download_processbar
        main_layout.addWidget(download_processbar)

        self.setLayout(main_layout)

    def start_btn_click(self):
        self.download_processbar.setValue(10)
        print('开始')

    def update_processbar_value(self, i):
        # print(f'更新下载进度 {i}')
        self.download_processbar.setValue(i)

    def start_download_file(self):
        # print('开始下载')
        file_url = self.download_url.text()
        print(f'开始下载 {file_url}')
        self.download_worker.set_url(file_url)
        # if not file_url:
        self.download_worker.start()


if __name__ == '__main__':
    print('main')
    app = QApplication(sys.argv)
    window = MainWindow()
    window.show()
    sys.exit(app.exec_())

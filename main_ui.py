import sys
from PyQt5.QtWidgets import QApplication, QWidget, QDesktopWidget
from PyQt5.QtWidgets import QVBoxLayout, QHBoxLayout
from PyQt5.QtWidgets import QPushButton


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

        self.setLayout(main_layout)

    def start_btn_click(self):
        print('开始')

if __name__ == '__main__':
    print('main')
    app = QApplication(sys.argv)
    window = MainWindow()
    window.show()
    sys.exit(app.exec_())

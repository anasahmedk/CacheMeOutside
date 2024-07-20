//
//  TransactionsViewController.swift
//  cacheMeSwiftApp
//
//  Created by Kaitlyn Sookdhew on 2024/07/20.
//

import UIKit

class TransactionsViewController: UIViewController {

    @IBOutlet weak var balance: UILabel!
    private lazy var viewModel = TransactionViewModel(repository: TransactionRepository(), delegate: self)


    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */

}

extension  TransactionsViewController: ViewModelDelegate {

    func reloadView(){

    }

    func show(error: String) {
    }
}

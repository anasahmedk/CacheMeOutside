//
//  TransactionsTableViewCell.swift
//  cacheMeSwiftApp
//
//  Created by Sebastian Jacobs on 2024/07/20.
//

import UIKit

class TransactionsTableViewCell: UITableViewCell {

    
    @IBOutlet weak var amount: UILabel!
    @IBOutlet weak var transactionDescription: UILabel!
    @IBOutlet weak var goodButton: UIButton!
    @IBOutlet weak var badButton: UIButton!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}

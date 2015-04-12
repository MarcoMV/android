class CreateCharges < ActiveRecord::Migration
  def change
    create_table :charges do |t|
      t.decimal :amount
      t.references :payer, index: true
      t.references :receiver, index: true
      t.references :plan, index: true
      t.string :verification_code
      t.boolean :verified

      t.timestamps
    end
  end
end

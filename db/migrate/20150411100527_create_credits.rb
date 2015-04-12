class CreateCredits < ActiveRecord::Migration
  def change
    create_table :credits do |t|
      t.decimal :amount
      t.string :compropago_payment_id
      t.references :user, index: true

      t.timestamps
    end
  end
end
